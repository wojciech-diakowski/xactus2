(:*******************************************************:)
(: Test: K-DateSubtractYMD-1                             :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: Simple testing involving operator '-' between xs:date and xs:yearMonthDuration. :)
(:*******************************************************:)
xs:date("1999-08-12") - xs:yearMonthDuration("P3Y7M")
					 eq xs:date("1996-01-12")