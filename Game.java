public class Game {

    private Player[] player;  // Array to store players in the game
    private Map map;  // Stores the map for the game

    // Default Constructor
    private Game() {
        this.player = new Player[10];  // Initializes array for 10 players
        this.map = null;  // Initializes map as null
    }

    // Overloaded constructor
    private Game(Player[] player, Map map) {
        this.player = player;  // Assigns player array
        this.map = map;  // Assigns map
    }

    // Copy constructor
    private Game(Game other) {
        this.player = new Player[other.player.length];  // Creates a new player array based on the size of the other game's player array
        for (int i = 0; i < other.player.length; i++) {
            this.player[i] = Player.getInstance(other.player[i]);  // Copies each player from the other game's player array
        }
        this.map = other.map;  // Copies the map reference from the other game
    }

    public Player[] getPlayer() {
        return player.clone();  // Returns a copy of the player array
    }

    public void setPlayer(Player[] player) {
        this.player = player.clone();  // Sets the player array as a copy of the input array
    }

    public Map getMap() {
        return map;  // Returns the map
    }

    public void setMap(Map map) {
        this.map = map.getInstance();  // Sets the map to a new instance based on the input map
    }

    // Static method to create a new instance of Game using the default constructor
    public static Game getInstance() {
        return new Game();
    }

    // Static method to create a new instance of Game using the overloaded constructor
    public static Game getInstance(Player[] player, Map map) {
        return new Game(player, map);
    }

    // Static method to create a new instance of Game using the copy constructor
    public static Game getInstance(Game game) {
        return new Game(game);
    }
}

class Player {

    public String name;  // Stores the name of the player
    public Role role;  // Stores the role of the player

    // Overloaded constructor
    private Player(String name, Role role) {
        this.name = name;  // Assigns player name
        this.role = role;  // Assigns player role
    }

    // Copy constructor
    private Player(Player other) {
        this.name = other.name;  // Copies the player's name
        this.role = other.role;  // Copies the player's role
    }

    public static Player getInstance(String name, Role role) {
        return new Player(name, role);  // Creates a new Player instance with a name and role
    }

    public static Player getInstance(Player other) {
        return new Player(other);  // Creates a copy of the given player
    }

    public String getName() {
        return name;  // Returns the player's name
    }

    public Role getRole() {
        return role;  // Returns the player's role
    }

    public void setName(String name) {
        this.name = name;  // Sets the player's name
    }

    public void setRole(Role role) {
        this.role = role.getInstance();  // Sets the player's role using a new instance of the given role
    }
}

class Map {

    public String theSkeld;  // Map name: The Skeld
    public String miraHq;  // Map name: Mira HQ
    public String polus;  // Map name: Polus
    public String airShip;  // Map name: Airship

    // Overloaded constructor
    private Map(String theSkeld, String miraHq, String polus, String airShip) {
        this.theSkeld = theSkeld;  // Assigns The Skeld map
        this.miraHq = miraHq;  // Assigns Mira HQ map
        this.polus = polus;  // Assigns Polus map
        this.airShip = airShip;  // Assigns Airship map
    }

    // Copy constructor
    private Map(Map other) {
        this.theSkeld = other.theSkeld;  // Copies The Skeld map
        this.miraHq = other.miraHq;  // Copies Mira HQ map
        this.polus = other.polus;  // Copies Polus map
        this.airShip = other.airShip;  // Copies Airship map
    }

    public static Map getInstance() {
        return new Map("", "", "", "");  // Returns a new instance of Map with empty names
    }

    public static Map getInstance(String theSkeld, String miraHq, String polus, String airShip) {
        return new Map(theSkeld, miraHq, polus, airShip);  // Returns a new instance of Map with specified map names
    }
}

class Role {

    public char role;  // Character to represent the player's role

    // Overloaded constructor
    private Role(char role) {
        this.role = role;  // Assigns the role
    }

    // Copy constructor
    private Role(Role other) {
        this.role = other.role;  // Copies the role
    }

    public static Role getInstance() {
        return new Role(' ');  // Returns a new instance of Role with a default value
    }

    public static Role getInstance(char role) {
        return new Role(role);  // Returns a new instance of Role with a specific role
    }

    public char getRole() {
        return role;  // Returns the role
    }

    public void setRole(char role) {
        this.role = role;  // Sets the role
    }
}
