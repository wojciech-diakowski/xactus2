(:*******************************************************:)
(: Test: K-SeqExprCast-790                               :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: Casting from xs:dayTimeDuration to xs:hexBinary isn't allowed. :)
(:*******************************************************:)
xs:dayTimeDuration("P3DT2H") cast as xs:hexBinary