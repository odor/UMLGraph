/*
 * (C) Copyright 2007-2008 Abstratt Technologies
 *
 * Permission to use, copy, and distribute this software and its
 * documentation for any purpose and without fee is hereby granted,
 * provided that the above copyright notice appear in all copies and that
 * both that copyright notice and this permission notice appear in
 * supporting documentation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND WITHOUT ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF
 * MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 * $Id$
 *
 */
package org.umlgraph.engine.classdiagram.dot;

import org.eclipse.uml2.uml.InterfaceRealization;
import org.umlgraph.engine.classdiagram.ElementRenderer;
import org.umlgraph.engine.classdiagram.RenderingSession;

public class InterfaceRealizationRenderer implements
        ElementRenderer<InterfaceRealization> {

    public void renderObject(InterfaceRealization element,
            RenderingSession context) {
        //TODO ClassInfo
        if (element.getImplementingClassifier().getNearestPackage() != element
                .getContract().getNearestPackage())
            return;
        IndentedPrintWriter pw = context.getOutput();
        pw.println("//" + element.getImplementingClassifier().getName() + " extends "
                + element.getContract().getName());
        pw.println(element.getContract().getName() + " -> "
                + element.getImplementingClassifier().getName()
                + "[dir=back,arrowtail=empty,style=dashed];");

    }
}
