(:*******************************************************:)
(: Test: K-SeqExprCast-1169                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: 'castable as' involving xs:gMonth as source type and xs:untypedAtomic as target type should always evaluate to true. :)
(:*******************************************************:)
xs:gMonth("--11") castable as xs:untypedAtomic