(:*******************************************************:)
(: Test: K-YearMonthDurationAddDT-1                      :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: Simple testing involving operator '+' between xs:dateTime and xs:yearMonthDuration. :)
(:*******************************************************:)
xs:dateTime("1999-07-19T08:23:01.765")
		+ xs:yearMonthDuration("P3Y35M") eq xs:dateTime("2005-06-19T08:23:01.765")