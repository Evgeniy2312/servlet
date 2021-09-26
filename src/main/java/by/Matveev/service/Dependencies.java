package by.Matveev.service;


import by.Matveev.dao.*;

public class Dependencies {
    public final static RecordingHistoryService recordingHistoryService = new RecordingHistoryService(new HibernateOperations());
    public final static CalculateService calculateService = new CalculateService();
    public final static AuthorizationService authorizationService = new AuthorizationService(new HibernateUser());
    public final static RegistrationService registrationService = new RegistrationService(new HibernateUser());
    public final static HistoryService2 historyService2 = new HistoryService2(new HibernateOperations());
    public final static ChangePasswordService changePasswordService = new ChangePasswordService(new HibernateUser());
    public final static TelephoneService telephoneService = new TelephoneService(new HibernateTelephone());
    public final static AddressService addressService = new AddressService(new HibernateAddress());
}
