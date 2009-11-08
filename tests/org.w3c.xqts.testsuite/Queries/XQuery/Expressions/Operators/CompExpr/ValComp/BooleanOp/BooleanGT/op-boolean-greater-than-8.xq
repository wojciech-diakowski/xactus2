(:*******************************************************:)
(:Test: op-boolean-greater-than-8                        :)
(:Written By: Carmelo Montanez                           :)
(:Date: June 15, 2005                                    :)
(:Purpose: Evaluates The "boolean-greater-than" function :)
(: with operands set to "not(false)", "false" respectively.:)
(: Use of le operator.                                   :)
(:*******************************************************:)
 
fn:not(xs:boolean("false")) le xs:boolean("false")