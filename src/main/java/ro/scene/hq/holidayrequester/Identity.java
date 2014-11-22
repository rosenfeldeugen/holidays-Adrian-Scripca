package ro.scene.hq.holidayrequester;

public class Identity {
    public String email;
    public String name;

    public static Identity fromEmailAndName(String email, String name) {
        Identity result = new Identity();
        result.email = email;
        result.name = name;
        return result;
    }

    public static Identity fromEmail(String email) {
        Identity result = new Identity();
        result.email = email;
        return result;
    }
}
