package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final IEmailSender emailSender;
    private final Clock clock;

    public BirthdayGreeter(EmployeeRepository employeeRepository, IEmailSender emailSender, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.emailSender = emailSender;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(this.emailSender::send);
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}