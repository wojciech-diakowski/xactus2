(:*******************************************************:)
(: Test: K-SeqExprCast-1047                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: 'castable as' involving xs:gYear as source type and xs:boolean as target type should always evaluate to false. :)
(:*******************************************************:)
not(xs:gYear("1999") castable as xs:boolean)