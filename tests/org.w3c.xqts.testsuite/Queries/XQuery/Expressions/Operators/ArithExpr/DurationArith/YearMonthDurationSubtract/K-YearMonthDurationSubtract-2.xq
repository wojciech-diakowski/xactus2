(:*******************************************************:)
(: Test: K-YearMonthDurationSubtract-2                   :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: Simple test of substraction P0M with an xs:yearMonthDuration. :)
(:*******************************************************:)
xs:yearMonthDuration("P0M") - xs:yearMonthDuration("P3Y3M")
			   eq xs:yearMonthDuration("-P3Y3M")