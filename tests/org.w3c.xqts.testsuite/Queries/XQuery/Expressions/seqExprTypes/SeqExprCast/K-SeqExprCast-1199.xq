(:*******************************************************:)
(: Test: K-SeqExprCast-1199                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: 'castable as' involving xs:gMonth as source type and xs:gDay as target type should always evaluate to false. :)
(:*******************************************************:)
not(xs:gMonth("--11") castable as xs:gDay)