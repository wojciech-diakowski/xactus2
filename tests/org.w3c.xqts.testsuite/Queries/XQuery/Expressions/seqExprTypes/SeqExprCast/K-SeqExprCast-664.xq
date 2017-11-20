(:*******************************************************:)
(: Test: K-SeqExprCast-664                               :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: Casting from xs:duration to xs:dayTimeDuration is allowed and should always succeed. :)
(:*******************************************************:)
xs:duration("P1Y2M3DT10H30M") cast as xs:dayTimeDuration
                    ne
                  xs:dayTimeDuration("P3DT2H")