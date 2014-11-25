package ro.scene.hq.holidayrequester;

public class SystemConfiguration {
    public static final Identity HR_IDENTITY = new Identity("hr@iquestgroup.com", "HR department");
    public static final EmailSender EMAIL_SENDER = new ConsolePrintEmailSender();
}
