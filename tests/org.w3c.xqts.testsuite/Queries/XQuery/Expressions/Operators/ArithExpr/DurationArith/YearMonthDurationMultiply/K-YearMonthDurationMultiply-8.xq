(:*******************************************************:)
(: Test: K-YearMonthDurationMultiply-8                   :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:36+02:00                       :)
(: Purpose: The multiplication operator is not available between xs:duration and xs:integer. :)
(:*******************************************************:)
xs:duration("P1Y3M") * 3