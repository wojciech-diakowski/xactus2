(:*******************************************************:)
(:Test: op-numeric-divideint2args-4                       :)
(:Written By: Carmelo Montanez                            :)
(:Date: Thu Dec 16 10:48:16 GMT-05:00 2004                :)
(:Purpose: Evaluates The "op:numeric-divide" operator    :)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:int(lower bound)                            :)
(:$arg2 = xs:int(mid range)                              :)
(:*******************************************************:)

fn:round-half-to-even((xs:int("-2147483648") div xs:int("-1873914410")),10)