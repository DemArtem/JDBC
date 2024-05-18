public class Character {
    private String name;

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                '}';
    }

    public Character(String name) {
        this.name = name;
    }
} 