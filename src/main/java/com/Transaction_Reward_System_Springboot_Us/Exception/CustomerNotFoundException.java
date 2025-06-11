// ================================
// CustomerNotFoundException.java
// ================================
package com.Transaction_Reward_System_Springboot_Us.Exception;

/**
 * Exception thrown when customer ID is not found in database.
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
