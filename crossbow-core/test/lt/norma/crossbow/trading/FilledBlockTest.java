/*
 * Copyright 2009, 2010 Vilius Normantas <code@norma.lt>
 * 
 * This file is part of Crossbow trading library.
 * 
 * Crossbow is free software: you can redistribute it and/or modify it under the terms of the GNU 
 * General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * Crossbow is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Crossbow.  If not, 
 * see <http://www.gnu.org/licenses/>.
 */

package lt.norma.crossbow.trading;

import java.math.BigDecimal;

import lt.norma.crossbow.exceptions.InvalidArgumentRuntimeException;
import lt.norma.crossbow.orders.Direction;
import lt.norma.crossbow.trading.FilledBlock;

import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test FilledBlock class.
 * 
 * @author Vilius Normantas <code@norma.lt>
 */
public class FilledBlockTest
{
   /**
    * Test the constructor.
    */
   @Test
   public void testCreation()
   {
      FilledBlock p =
            new FilledBlock(Direction.LONG, 100, new BigDecimal("8.0"), new DateTime(500));
      assertEquals(100, p.getSize());
      assertTrue((new BigDecimal("8")).compareTo(p.getAveragePrice()) == 0);
      assertEquals(new DateTime(500), p.getTime());
      assertEquals(Direction.LONG, p.getDirection());
   }
   
   /**
    * Test the constructor.
    */
   @Test(expected = InvalidArgumentRuntimeException.class)
   public void testCreation2()
   {
      new FilledBlock(Direction.LONG, 0, new BigDecimal("8.0"), new DateTime(500));
   }
   
   /**
    * Test the constructor.
    */
   @Test(expected = InvalidArgumentRuntimeException.class)
   public void testCreation3()
   {
      new FilledBlock(Direction.LONG, -200, new BigDecimal("8.0"), new DateTime(500));
   }
   
   /**
    * Test of calculateValue method, of class FilledBlock.
    */
   @Test
   public void testCalculateValue()
   {
      FilledBlock p =
            new FilledBlock(Direction.SHORT, 100, new BigDecimal("8.501"), new DateTime(500));
      assertTrue((new BigDecimal("850.1")).compareTo(p.calculateValue()) == 0);
   }
}
