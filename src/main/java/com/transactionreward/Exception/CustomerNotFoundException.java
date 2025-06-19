// ================================
// CustomerNotFoundException.java
// ================================
package com.transactionreward.Exception;

/**
 * Exception thrown when customer ID is not found in database.
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
