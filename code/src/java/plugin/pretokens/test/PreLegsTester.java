/*
 * PreLegs.java
 * Copyright 2001 (C) Bryan McRoberts <merton_monk@yahoo.com>
 * Copyright 2003 (C) Chris Ward <frugal@purplewombat.co.uk>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	   See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 *
 *
 */
package plugin.pretokens.test;

import pcgen.cdom.base.CDOMObject;
import pcgen.core.display.CharacterDisplay;
import pcgen.core.prereq.AbstractDisplayPrereqTest;
import pcgen.core.prereq.Prerequisite;
import pcgen.core.prereq.PrerequisiteException;
import pcgen.core.prereq.PrerequisiteTest;
import pcgen.system.LanguageBundle;

/**
 *
 */
public class PreLegsTester extends AbstractDisplayPrereqTest implements
		PrerequisiteTest
{

	/**
	 * @see pcgen.core.prereq.PrerequisiteTest#passes(pcgen.core.PlayerCharacter)
	 */
	@Override
	public int passes(final Prerequisite prereq, final CharacterDisplay display, CDOMObject source)
		throws PrerequisiteException
	{
		int runningTotal;
		try
		{
			final int targetLegs = Integer.parseInt(prereq.getOperand());

			runningTotal =
					prereq.getOperator().compare(display.getPreFormulaLegs(),
						targetLegs);
		}
		catch (NumberFormatException nfe)
		{
			throw new PrerequisiteException(LanguageBundle.getFormattedString(
				"PreLegs.error.bad_operand", prereq.getOperand())); //$NON-NLS-1$
		}
		return countedTotal(prereq, runningTotal);
	}

	/**
	 * Get the type of prerequisite handled by this token.
	 * @return the type of prerequisite handled by this token.
	 */
    @Override
	public String kindHandled()
	{
		return "LEGS"; //$NON-NLS-1$
	}

}
