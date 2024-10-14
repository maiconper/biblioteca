package com.example.demo.user;

public enum Role {
	
    ADMIN(1,"Admin"), 
    LIBRARIAN(2,"Librarian"), 
    USER(3,"User");
	
    private final int id;
    private final String displayName;
	
    Role(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

	public int getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}
	
    // Método para buscar Role pelo id
    public static Role getById(int id) {
        for (Role role : Role.values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role ID: " + id);
    }

    // Método para buscar Role pelo nome
    public static Role getByName(String name) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(name)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role Name: " + name);
    }
}
