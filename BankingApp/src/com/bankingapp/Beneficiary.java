package com.bankingapp;

public record Beneficiary(String name, String accountNo) {

    // Return false only for "james", true otherwise
    public boolean validateBene(String name) {
        return name != null && !name.equalsIgnoreCase("james");
    }

    // Proper equals override for record (optional but fixed)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficiary b)) return false;
        return name.equals(b.name) && accountNo.equals(b.accountNo);
    }
}
