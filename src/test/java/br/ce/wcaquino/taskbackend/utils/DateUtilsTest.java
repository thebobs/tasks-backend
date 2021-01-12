package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {

	@Test 
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		System.out.print(DateUtils.isEqualOrFutureDate(date));
		//testar de novo
	}
	
	@Test
	public void deveRetornarTrueParaDatasPassadas() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		System.out.print(DateUtils.isEqualOrFutureDate(date));
	}
	@Test
	public void deveRetornarTrueParaDataAtual() {
		LocalDate date = LocalDate.now();
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		System.out.print(DateUtils.isEqualOrFutureDate(date));
	}
}
