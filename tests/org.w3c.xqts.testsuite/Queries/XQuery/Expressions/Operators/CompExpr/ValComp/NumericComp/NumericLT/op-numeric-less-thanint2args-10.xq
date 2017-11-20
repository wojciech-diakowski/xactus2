(:*******************************************************:)
(:Test: op-numeric-less-thanint2args-10                   :)
(:Written By: Carmelo Montanez                            :)
(:Date: Thu Dec 16 10:48:16 GMT-05:00 2004                :)
(:Purpose: Evaluates The "op:numeric-less-than" operator :)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:int(lower bound)                            :)
(:$arg2 = xs:int(upper bound)                            :)
(:*******************************************************:)

xs:int("-2147483648") ge xs:int("2147483647")