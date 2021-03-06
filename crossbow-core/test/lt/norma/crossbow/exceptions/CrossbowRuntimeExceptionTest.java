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

package lt.norma.crossbow.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Vilius Normantas <code@norma.lt>
 */
public class CrossbowRuntimeExceptionTest
{
   
   /**
    * Test method for
    * {@link lt.norma.crossbow.exceptions.CrossbowRuntimeException#CrossbowRuntimeException(java.lang.String, java.lang.Throwable)}
    * .
    */
   @Test
   public void testCrossbowRuntimeExceptionStringThrowable()
   {
      Exception cause = new Exception();
      CrossbowRuntimeException e = new CrossbowRuntimeException("ABC", cause);
      assertEquals("ABC", e.getMessage());
      assertEquals(cause, e.getCause());
      
      CrossbowRuntimeException e2 = new CrossbowRuntimeException("DEF", null);
      assertEquals("DEF", e2.getMessage());
      assertNull(e2.getCause());      
   }
   
   /**
    * Test method for
    * {@link lt.norma.crossbow.exceptions.CrossbowRuntimeException#CrossbowRuntimeException(java.lang.String)}
    * .
    */
   @Test
   public void testCrossbowRuntimeExceptionString()
   {
      CrossbowRuntimeException e = new CrossbowRuntimeException("DEF");
      assertEquals("DEF", e.getMessage());
      assertNull(e.getCause());
   }
   
}
