(:*******************************************************:)
(:Test: op-time-equal2args-10                             :)
(:Written By: Carmelo Montanez                            :)
(:Date: Tue Apr 12 16:29:07 GMT-05:00 2005                :)
(:Purpose: Evaluates The "op:time-equal" operator        :)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:time(lower bound)                           :)
(:$arg2 = xs:time(upper bound)                           :)
(:*******************************************************:)

xs:time("00:00:00Z") ne xs:time("23:59:59Z")