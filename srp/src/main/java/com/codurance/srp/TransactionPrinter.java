package com.codurance.srp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class TransactionPrinter {
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String AMOUNT_FORMAT = "#.00";

    private final TransactionRepository transactionRepository;
    private final Printer printer;

    public TransactionPrinter(TransactionRepository transactionRepository, Printer printer) {
        this.transactionRepository = transactionRepository;
        this.printer = printer;
    }

    public void printStatement() {
        this.printHeader();
        this.printTransactions();
    }

    private void printHeader() {
        this.printer.printLine(STATEMENT_HEADER);
    }

    private void printTransactions() {
        final AtomicInteger balance = new AtomicInteger(0);
        transactionRepository.all().stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(this.printer::printLine);
    }

    private String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}", formatDate(transaction.date()), formatNumber(transaction.amount()), formatNumber(balance));
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return dateFormatter.format(date);
    }

    private String formatNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(AMOUNT_FORMAT, DecimalFormatSymbols.getInstance(Locale.UK));
        return decimalFormat.format(amount);
    }
}
