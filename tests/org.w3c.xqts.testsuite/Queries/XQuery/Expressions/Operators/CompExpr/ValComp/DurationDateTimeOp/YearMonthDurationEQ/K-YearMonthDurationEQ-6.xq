(:*******************************************************:)
(: Test: K-YearMonthDurationEQ-6                         :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: The xs:yearMonthDuration values -P0M and P0M are equal. :)
(:*******************************************************:)
xs:yearMonthDuration("-P3Y8M") ne xs:yearMonthDuration("P3Y8M")