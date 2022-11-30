package com.comercia.rentalcar.constants;

import java.math.BigDecimal;

public final class Constants {

		private Constants() {
			
		}
		
		public static final int DECIMALSTODIVIDE = 4;
		public static final int NUMDECIMAL = 2;
		public static final BigDecimal BDNUMBERCIEN = new BigDecimal(100);
		public static final BigDecimal ZERO = BigDecimal.ZERO;
		
	
		
// PODRIAN METERSE EN UN FICHERO DE CONFIGURACION Y CONFIGURAR LOS BEANS CON UN @CONFIG PARA RECUPERARLOS, DE FORMA QUE SERIA MUCHO MAS RAPIO DESPLEGAR SI HAY QUE CAMBIARLOS 
		public static final BigDecimal SURCHAGE_PREMIUM =BigDecimal.valueOf(0.2);
		public static final BigDecimal SURCHAGE_SUV = BigDecimal.valueOf(0.6);
		public static final BigDecimal SURCHAGE_SMALL = BigDecimal.valueOf(0.3);
		
		
		public static final BigDecimal PRICE_PREMIUM =BigDecimal.valueOf(300.00);
		public static final BigDecimal PRICE_SUV= BigDecimal.valueOf(150.00);
		public static final BigDecimal PRICE_SMALL = BigDecimal.valueOf(50.00);
		
		public static final Integer POINTS_PREMIUM =5;
		public static final Integer POINTS_SUV= 3;
		public static final Integer POINTS_SMALL = 1;
		
}
