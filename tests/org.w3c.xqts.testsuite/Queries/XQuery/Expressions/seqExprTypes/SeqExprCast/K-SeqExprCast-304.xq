(:*******************************************************:)
(: Test: K-SeqExprCast-304                               :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: Testing timezone field in xs:gMonthDay: the minute component cannot be +60. :)
(:*******************************************************:)
xs:gMonthDay("--01-01+10:60")