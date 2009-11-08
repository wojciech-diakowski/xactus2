(:*******************************************************:)
(:Test: deep-equalnpi2args-3                              :)
(:Written By: Carmelo Montanez                            :)
(:Date: Fri Dec 10 10:15:47 GMT-05:00 2004                :)
(:Purpose: Evaluates The "deep-equal" function           :)
(: with the arguments set as follows:                    :)
(:$parameter1 = xs:nonPositiveInteger(upper bound)       :)
(:$parameter2 = xs:nonPositiveInteger(lower bound)       :)
(:*******************************************************:)

fn:deep-equal((xs:nonPositiveInteger("0")),(xs:nonPositiveInteger("-999999999999999999")))