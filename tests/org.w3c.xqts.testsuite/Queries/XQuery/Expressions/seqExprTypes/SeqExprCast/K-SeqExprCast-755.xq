(:*******************************************************:)
(: Test: K-SeqExprCast-755                               :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: 'castable as' involving xs:dayTimeDuration as source type and xs:string as target type should always evaluate to true. :)
(:*******************************************************:)
xs:dayTimeDuration("P3DT2H") castable as xs:string