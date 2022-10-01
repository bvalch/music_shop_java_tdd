package instruments;

public enum InstrumentType {
    GUITAR("Guitar", "WahWah", "Guitarium"),
    PIANO("Piano", "DingDong", "BitsAndPieces"),
    DRUMS("Drums", "Badum", "Corinthian Leather");

    private String name;
    private String sound;
    private String material;

    InstrumentType(String name, String sound, String material) {
        this.name = name;
        this.sound = sound;
        this.material = material;

    }

    public String getName() {
        return this.name;
    }
    public String getSound() {return this.sound;}
    public String getMaterial() {
        return this.material;
    }

}
