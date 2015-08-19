/**
 * Copyright (C) 2015 MCGenrix
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.grafxteam.sr.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class MainDisplayClass {

	public static void createDisplay() {

		ContextAttribs attribs = new ContextAttribs(4, 5);
		attribs.withForwardCompatible(true);
		attribs.withProfileCore(true);

		try {
			Display.setDisplayMode(new DisplayMode(DisplayParams.WIDTH, DisplayParams.HEIGHT));
			Display.create(new PixelFormat(), attribs);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Display.setTitle(DisplayParams.TITLE + DisplayParams.VER);

		GL11.glViewport(0, 0, DisplayParams.WIDTH, DisplayParams.HEIGHT);

	}

	public static void updateDisplay() {

		Display.sync(DisplayParams.FPS_CAP);
		Display.update();

	}

	public static void closeDisplay() {

		Display.destroy();

	}

}
