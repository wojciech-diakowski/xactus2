(:*******************************************************:)
(:Test: op-time-less-than2args-8                          :)
(:Written By: Carmelo Montanez                            :)
(:Date: Tue Apr 12 16:29:07 GMT-05:00 2005                :)
(:Purpose: Evaluates The "op:time-less-than" operator    :)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:time(upper bound)                           :)
(:$arg2 = xs:time(lower bound)                           :)
(:*******************************************************:)

xs:time("23:59:59Z") ge xs:time("00:00:00Z")