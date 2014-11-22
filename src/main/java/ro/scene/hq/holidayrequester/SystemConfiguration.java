package ro.scene.hq.holidayrequester;

public class SystemConfiguration {
    public static final Identity HR_IDENTITY = Identity.fromEmail("hr@iquestgroup.com");
    public static final EmailSender EMAIL_SENDER = new ConsolePrintEmailSender();
}
