(:*******************************************************:)
(: Test: K-YearMonthDurationAddDT-3                      :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: The '+' operator is not available between xs:date and xs:time. :)
(:*******************************************************:)
xs:date("1999-10-12") + xs:time("08:12:12")