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

package lt.norma.crossbow.orders;

import java.math.BigDecimal;

import lt.norma.crossbow.contracts.Contract;
import lt.norma.crossbow.exceptions.OrderException;

/**
 * Stop order.
 * 
 * @author Vilius Normantas <code@norma.lt>
 */
public final class StopOrder extends Order
{
   /** Stop price. */
   private final BigDecimal stopPrice;
   /** Order type. */
   private static final String ORDER_TYPE = "stop";
   
   /**
    * Constructor.
    * 
    * @param id
    *           local order ID. Make sure to set unique IDs for each order within context of the
    *           application.
    * @param contract
    *           contract of a traded instrument
    * @param direction
    *           direction of the trade
    * @param stopPrice
    *           stop price
    * @param size
    *           size of an order. Must be greater than zero. Use <code>direction</code> to set
    *           direction of the order
    * @throws OrderException
    *            on invalid order details
    */
   public StopOrder(long id, Contract contract, Direction direction, int size,
         BigDecimal stopPrice) throws OrderException
   {
      super(id, contract, ORDER_TYPE, direction, size);
      this.stopPrice = stopPrice;
   }
   
   /**
    * Gets stop price.
    * 
    * @return stop price
    */
   public BigDecimal getStopPrice()
   {
      return stopPrice;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + " at " + stopPrice.toPlainString();
   }
}
