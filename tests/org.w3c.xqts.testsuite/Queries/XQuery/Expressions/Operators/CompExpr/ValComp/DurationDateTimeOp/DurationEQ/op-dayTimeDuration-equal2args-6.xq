(:*******************************************************:)
(:Test: op-dayTimeDuration-equal2args-6                   :)
(:Written By: Carmelo Montanez                            :)
(:Date: Tue Apr 12 16:29:06 GMT-05:00 2005                :)
(:Purpose: Evaluates The "op:dayTimeDuration-equal" operator:)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:dayTimeDuration(lower bound)               :)
(:$arg2 = xs:dayTimeDuration(lower bound)               :)
(:*******************************************************:)

xs:dayTimeDuration("P0DT0H0M0S") ne xs:dayTimeDuration("P0DT0H0M0S")