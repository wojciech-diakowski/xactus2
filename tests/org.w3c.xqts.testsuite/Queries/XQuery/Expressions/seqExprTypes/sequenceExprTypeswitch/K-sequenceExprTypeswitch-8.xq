(:*******************************************************:)
(: Test: K-sequenceExprTypeswitch-8                      :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: A typeswitch where the case clauses will never be evaluated. In some implementations this trigger optimization code paths. :)
(:*******************************************************:)

		(typeswitch(1, 2, current-time())
			case element() return -1
			case document-node() return -2
			default return 1)
		eq 1
	