(:*******************************************************:)
(: Test: K-SeqExprCast-1063                              :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: It is not possible to extract an Effective Boolean Value from the type xs:gMonthDay, with the boolean() function. :)
(:*******************************************************:)
boolean(xs:gMonthDay("--11-13"))