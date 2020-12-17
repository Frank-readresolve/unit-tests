package fr.formation.training.unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class InvoiceUT {

    @Test
    void shouldCreateInvoice() {
	LocalDate now = LocalDate.now();
	Invoice actual = new Invoice("INV-1", now);
	assertNotNull(actual);
    }

    @Test
    void shouldNotCreateInvoiceWithNullInvoiceNumber() {
	LocalDate now = LocalDate.now();
	assertThrows(NullPointerException.class, () -> new Invoice(null, now));
    }

    @Test
    void shouldNotCreateInvoiceWithNullDate() {
	assertThrows(NullPointerException.class,
		() -> new Invoice("INV-1", null));
    }

    @Test
    void shouldNotCreateInvoiceWithNullArgs() {
	assertThrows(NullPointerException.class, () -> new Invoice(null, null));
    }

    @Test
    void shouldNotCreateInvoiceWithIllegalDate() {
	LocalDate now = LocalDate.now();
	LocalDate tomorrow = now.plusDays(1);
	assertThrows(IllegalArgumentException.class,
		() -> new Invoice("INV-1", tomorrow));
    }

    @Test
    void shouldGetSameInvoiceNumberAndDate() {
	String expectedInvoiceNumber = "INV-1";
	LocalDate expectedDate = LocalDate.now();
	Invoice invoice = new Invoice(expectedInvoiceNumber, expectedDate);
	// Assertions:
	assertEquals(invoice.getInvoiceNumber(), expectedInvoiceNumber);
	assertEquals(invoice.getDate(), expectedDate);
    }
}
