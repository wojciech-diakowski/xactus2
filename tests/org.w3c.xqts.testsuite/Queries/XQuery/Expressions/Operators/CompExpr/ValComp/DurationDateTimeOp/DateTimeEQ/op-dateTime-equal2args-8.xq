(:*******************************************************:)
(:Test: op-dateTime-equal2args-8                          :)
(:Written By: Carmelo Montanez                            :)
(:Date: Tue Apr 12 16:29:06 GMT-05:00 2005                :)
(:Purpose: Evaluates The "op:dateTime-equal" operator    :)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:dateTime(upper bound)                       :)
(:$arg2 = xs:dateTime(lower bound)                       :)
(:*******************************************************:)

xs:dateTime("2030-12-31T23:59:59Z") ne xs:dateTime("1970-01-01T00:00:00Z")