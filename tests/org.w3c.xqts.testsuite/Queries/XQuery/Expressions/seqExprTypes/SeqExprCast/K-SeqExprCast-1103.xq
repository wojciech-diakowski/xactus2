(:*******************************************************:)
(: Test: K-SeqExprCast-1103                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: 'castable as' involving xs:gMonthDay as source type and xs:hexBinary as target type should always evaluate to false. :)
(:*******************************************************:)
not(xs:gMonthDay("--11-13") castable as xs:hexBinary)