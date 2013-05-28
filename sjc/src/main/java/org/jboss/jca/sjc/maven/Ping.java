/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2012, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.jca.sjc.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * A ping mojo
 * @author <a href="mailto:jesper.pedersen@ironjacamar.org">Jesper Pedersen</a>
 */
public class Ping extends AbstractHostPortMojo
{
   /**
    * Constructor
    */
   public Ping()
   {
   }

   /**
    * {@inheritDoc}
    */
   public void execute() throws MojoExecutionException, MojoFailureException
   {
      try
      {
         if (isLocal())
         {
            if (!isCommandAvailable("local-list"))
               throw new MojoFailureException("Unable to ping " + getHost() + ":" + getPort());
         }
         else
         {
            if (!isCommandAvailable("remote-list"))
               throw new MojoFailureException("Unable to ping " + getHost() + ":" + getPort());
         }
      }
      catch (Throwable t)
      {
         throw new MojoFailureException("Unable to ping " + getHost() + ":" + getPort() +
                                        " (" + t.getMessage() + ")", t);
      }
   }
}
