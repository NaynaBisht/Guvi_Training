package com.loggingapp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;  // ✅

//import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class FundTransferServiceTest {
	
//	@Test
//    public void testFundTransfer() {
//        FundTransferService obj = Mockito.mock(FundTransferService.class);
//        
//        when(objvalidateCustomer("Roy")).thenReturn(false);
//        
//        TransactionApp obj = new TransactionApp(objf);
//        
//        boolean response = obj.processTransaction("Roy", "kiran");
//        
//        assertFalse(response);
//        verify(objf).validateCustomer("Roy");
//    }
//	
//	@Test
//    public void testFundTransfer() {
//        FundTransferService obj = Mockito.mock(FundTransferService.class);
//        
//        when(objvalidateCustomer("Roy")).thenReturn(false);
//        
//        TransactionApp obj = new TransactionApp(objf);
//        
//        boolean response = obj.processTransaction("Roy", "kiran");
//        
//        assertFalse(response);
//        verify(objf).validateCustomer("Roy");
//    }

    @Test
    public void testInvalidAmount() {
        FundTransferService service = new FundTransferService(new SimpleAccountService());
        String result = service.transfer("A1", "A2", 0);
        assertEquals("FAILURE: Invalid amount", result);
    }

    @Test
    public void testSameAccount() {
        FundTransferService service = new FundTransferService(new SimpleAccountService());
        String result = service.transfer("A1", "A1", 100);
        assertEquals("FAILURE: Source and destination cannot be same", result);
    }

    @Test
    public void testInsufficientFunds() {
        SimpleAccountService acc = new SimpleAccountService();
        FundTransferService service = new FundTransferService(acc);
        String result = service.transfer("A1", "A2", 1000); // more than balance
        assertEquals("FAILURE: Insufficient funds", result);
    }

    @Test
    public void testSuccessfulTransfer() {
        SimpleAccountService acc = new SimpleAccountService();
        FundTransferService service = new FundTransferService(acc);
        String result = service.transfer("A1", "A2", 200);
        assertEquals("SUCCESS: Transfer completed", result);
    }

    @Test
    public void testDestinationAccountNotFound() {
        SimpleAccountService acc = new SimpleAccountService() {
            @Override
            public boolean exists(String accountNumber) {
                return accountNumber.equals("A1"); // A2 does not exist
            }
        };
        FundTransferService service = new FundTransferService(acc);
        String result = service.transfer("A1", "A2", 200);
        assertEquals("FAILURE: Destination account not found", result);
    }
}
