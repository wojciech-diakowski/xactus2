(:*******************************************************:)
(: Test: K-gYearEQ-2                                     :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: Simple test of 'eq' for xs:gYear.            :)
(:*******************************************************:)
not(xs:gYear("1956") eq xs:gYear("1958"))