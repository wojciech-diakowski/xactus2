(:*******************************************************:)
(: Test: K-SeqExprCast-1223                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:39+02:00                       :)
(: Purpose: 'castable as' involving xs:boolean as source type and xs:string as target type should always evaluate to true. :)
(:*******************************************************:)
xs:boolean("true") castable as xs:string