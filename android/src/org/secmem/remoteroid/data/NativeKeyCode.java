/*
 * Remoteroid - A remote control solution for Android platform, including handy file transfer and notify-to-PC.
 * Copyright (C) 2012 Taeho Kim(jyte82@gmail.com), Hyomin Oh(ohmnia1112@gmail.com), Hongkyun Kim(godgjdgjd@nate.com), Yongwan Hwang(singerhwang@gmail.com)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

package org.secmem.remoteroid.data;

/**
 * Represents Keycode defined in kernel source, <linux/input.h> and Generic.kl keylayout files.</br>
 * Based on API level 14.
 * @author Taeho Kim
 *
 */
public class NativeKeyCode {
	public static final int KEY_RESERVED = 0;
	public static final int KEY_ESC = 1;
	public static final int KEY_1 = 2;
	public static final int KEY_2 = 3;
	public static final int KEY_3 = 4;
	public static final int KEY_4 = 5;
	public static final int KEY_5 = 6;
	public static final int KEY_6 = 7;
	public static final int KEY_7 = 8;
	public static final int KEY_8 = 9;
	public static final int KEY_9 = 10;
	public static final int KEY_0 = 11;
	public static final int KEY_MINUS = 12;
	public static final int KEY_EQUAL = 13;
	public static final int KEY_BACKSPACE = 14;
	public static final int KEY_TAB = 15;
	public static final int KEY_Q = 16;
	public static final int KEY_W = 17;
	public static final int KEY_E = 18;
	public static final int KEY_R = 19;
	public static final int KEY_T = 20;
	public static final int KEY_Y = 21;
	public static final int KEY_U = 22;
	public static final int KEY_I = 23;
	public static final int KEY_O = 24;
	public static final int KEY_P = 25;
	public static final int KEY_LEFTBRACE = 26;
	public static final int KEY_RIGHTBRACE = 27;
	public static final int KEY_ENTER = 28;
	public static final int KEY_LEFTCTRL = 29;
	public static final int KEY_A = 30;
	public static final int KEY_S = 31;
	public static final int KEY_D = 32;
	public static final int KEY_F = 33;
	public static final int KEY_G = 34;
	public static final int KEY_H = 35;
	public static final int KEY_J = 36;
	public static final int KEY_K = 37;
	public static final int KEY_L = 38;
	public static final int KEY_SEMICOLON = 39;
	public static final int KEY_APOSTROPHE = 40;
	public static final int KEY_GRAVE = 41;
	public static final int KEY_LEFTSHIFT = 42;
	public static final int KEY_BACKSLASH = 43;
	public static final int KEY_Z = 44;
	public static final int KEY_X = 45;
	public static final int KEY_C = 46;
	public static final int KEY_V = 47;
	public static final int KEY_B = 48;
	public static final int KEY_N = 49;
	public static final int KEY_M = 50;
	public static final int KEY_COMMA = 51;
	public static final int KEY_DOT = 52;
	public static final int KEY_SLASH = 53;
	public static final int KEY_RIGHTSHIFT = 54;
	public static final int KEY_KPASTERISK = 55;
	public static final int KEY_LEFTALT = 56;
	public static final int KEY_SPACE = 57;
	public static final int KEY_CAPSLOCK = 58;
	public static final int KEY_F1 = 59;
	public static final int KEY_F2 = 60;
	public static final int KEY_F3 = 61;
	public static final int KEY_F4 = 62;
	public static final int KEY_F5 = 63;
	public static final int KEY_F6 = 64;
	public static final int KEY_F7 = 65;
	public static final int KEY_F8 = 66;
	public static final int KEY_F9 = 67;
	public static final int KEY_F10 = 68;
	public static final int KEY_NUMLOCK = 69;;
	public static final int KEY_SCROLLLOCK = 70;
	public static final int KEY_KP7 = 71;
	public static final int KEY_KP8 = 72;
	public static final int KEY_KP9 = 73;
	public static final int KEY_KPMINUS = 74;
	public static final int KEY_KP4 = 75;
	public static final int KEY_KP5 = 76;
	public static final int KEY_KP6 = 77;
	public static final int KEY_KPPLUS = 78;
	public static final int KEY_KP1 = 79;
	public static final int KEY_KP2 = 80;
	public static final int KEY_KP3 = 81;
	public static final int KEY_KP0 = 82;
	public static final int KEY_KPDOT = 83;

	public static final int KEY_ZENKAKUHANKAKU = 85;
	public static final int KEY_102ND = 86;
	public static final int KEY_F11 = 87;
	public static final int KEY_F12 = 88;
	public static final int KEY_RO = 89;
	public static final int KEY_KATAKANA = 90;
	public static final int KEY_HIRAGANA = 91;
	public static final int KEY_HENKAN = 92;
	public static final int KEY_KATAKANAHIRAGANA = 93;
	public static final int KEY_MUHENKAN = 94;
	public static final int KEY_KPJPCOMMA = 95;
	public static final int KEY_KPENTER = 96;
	public static final int KEY_RIGHTCTRL = 97;
	public static final int KEY_KPSLASH = 98;
	public static final int KEY_SYSRQ = 99;
	public static final int KEY_RIGHTALT = 100;
	public static final int KEY_LINEFEED = 101;
	/**
	 * Keylayout qwerty defined home as this, but Generic.kl uses other one </br>
	 * Use {@link #KEY_HOME} instead.
	 */
	public static final int KEY_MOVE_HOME = 102; // 
	public static final int KEY_UP = 103;
	public static final int KEY_PAGEUP = 104;
	public static final int KEY_LEFT = 105;
	public static final int KEY_RIGHT = 106;
	public static final int KEY_END = 107;
	public static final int KEY_DOWN = 108;
	public static final int KEY_PAGEDOWN = 109;
	public static final int KEY_INSERT = 110;
	public static final int KEY_DELETE = 111;
	public static final int KEY_MACRO = 112;
	public static final int KEY_MUTE = 113;
	public static final int KEY_VOLUMEDOWN = 114;
	public static final int KEY_VOLUMEUP = 115;
	public static final int KEY_POWER = 116;
	public static final int KEY_KPEQUAL = 117;
	public static final int KEY_KPPLUSMINUS = 118;
	public static final int KEY_PAUSE = 119;

	public static final int KEY_KPCOMMA = 121;
	public static final int KEY_HANGEUL = 122;
	public static final int KEY_HANGUEL = KEY_HANGEUL;
	public static final int KEY_HANJA = 123;
	public static final int KEY_YEN = 124;
	public static final int KEY_LEFTMETA = 125;
	public static final int KEY_RIGHTMETA = 126;
	public static final int KEY_MENU = 127;

	public static final int KEY_STOP = 128;
	public static final int KEY_AGAIN = 129;
	public static final int KEY_PROPS = 130;
	public static final int KEY_UNDO = 131;
	public static final int KEY_FRONT = 132;
	public static final int KEY_COPY = 133;
	public static final int KEY_OPEN = 134;
	public static final int KEY_PASTE = 135;
	public static final int KEY_FIND = 136;
	public static final int KEY_CUT = 137;
	public static final int KEY_HELP = 138;
	public static final int KEY_MENU2 = 139; 
	public static final int KEY_CALC = 140;
	public static final int KEY_SETUP = 141;
	public static final int KEY_SLEEP = 142;
	public static final int KEY_WAKEUP = 143;
	public static final int KEY_FILE = 144;
	public static final int KEY_SENDFILE = 145;
	public static final int KEY_DELETEFILE = 146;
	public static final int KEY_XFER = 147;
	public static final int KEY_PROG1 = 148;
	public static final int KEY_PROG2 = 149;
	public static final int KEY_WWW = 150;
	public static final int KEY_MSDOS = 151;
	public static final int KEY_COFFEE = 152;
	public static final int KEY_DIRECTION = 153;
	public static final int KEY_CYCLEWINDOWS = 154;
	public static final int KEY_MAIL = 155;
	public static final int KEY_BOOKMARKS = 156;
	public static final int KEY_COMPUTER = 157;
	public static final int KEY_BACK = 158;
	public static final int KEY_FORWARD = 159;
	public static final int KEY_CLOSECD = 160;
	public static final int KEY_EJECTCD = 161;
	public static final int KEY_EJECTCLOSECD = 162;
	public static final int KEY_NEXTSONG = 163;
	public static final int KEY_PLAYPAUSE = 164;
	public static final int KEY_PREVIOUSSONG = 165;
	public static final int KEY_STOPCD = 166;
	public static final int KEY_RECORD = 167;
	public static final int KEY_REWIND = 168;
	public static final int KEY_PHONE = 169;
	public static final int KEY_ISO = 170;
	public static final int KEY_CONFIG = 171;
	public static final int KEY_HOME = 172;
	public static final int KEY_REFRESH = 173;
	public static final int KEY_EXIT = 174;
	public static final int KEY_MOVE = 175;
	public static final int KEY_EDIT = 176;
	public static final int KEY_SCROLLUP = 177;
	public static final int KEY_SCROLLDOWN = 178;
	public static final int KEY_KPLEFTPAREN = 179;
	public static final int KEY_KPRIGHTPAREN = 180;
	public static final int KEY_NEW = 181;
	public static final int KEY_REDO = 182;

	public static final int KEY_F13 = 183;
	public static final int KEY_F14 = 184;
	public static final int KEY_F15 = 185;
	public static final int KEY_F16 = 186;
	public static final int KEY_F17 = 187;
	public static final int KEY_F18 = 188;
	public static final int KEY_F19 = 189;
	public static final int KEY_F20 = 190;
	public static final int KEY_F21 = 191;
	public static final int KEY_F22 = 192;
	public static final int KEY_F23 = 193;
	public static final int KEY_F24 = 194;

	public static final int KEY_PLAYCD = 200;
	public static final int KEY_PAUSECD = 201;
	public static final int KEY_PROG3 = 202;
	public static final int KEY_PROG4 = 203;
	public static final int KEY_SUSPEND = 205;
	public static final int KEY_CLOSE = 206;
	public static final int KEY_PLAY = 207;
	public static final int KEY_FASTFORWARD = 208;
	public static final int KEY_BASSBOOST = 209;
	public static final int KEY_PRINT = 210;
	public static final int KEY_HP = 211;
	public static final int KEY_CAMERA = 212;
	public static final int KEY_SOUND = 213;
	public static final int KEY_QUESTION = 214;
	public static final int KEY_EMAIL = 215;
	public static final int KEY_CHAT = 216;
	public static final int KEY_SEARCH = 217;
	public static final int KEY_CONNECT = 218;
	public static final int KEY_FINANCE = 219;
	public static final int KEY_SPORT = 220;
	public static final int KEY_SHOP = 221;
	public static final int KEY_ALTERASE = 222;
	public static final int KEY_CANCEL = 223;
	public static final int KEY_BRIGHTNESSDOWN = 224;
	public static final int KEY_BRIGHTNESSUP = 225;
	public static final int KEY_MEDIA = 226;

	public static final int KEY_STAR = 227;
	public static final int KEY_SHARP = 228;
	public static final int KEY_SOFT1 = 229;
	public static final int KEY_SOFT2 = 230;
	public static final int KEY_SEND = 231;
	public static final int KEY_CENTER = 232;
	public static final int KEY_HEADSETHOOK = 233;
	public static final int KEY_0_5 = 234;
	public static final int KEY_2_5 = 235;

	public static final int KEY_SWITCHVIDEOMODE = 236;
	public static final int KEY_KBDILLUMTOGGLE = 237;
	public static final int KEY_KBDILLUMDOWN = 238;
	public static final int KEY_KBDILLUMUP = 239;

	public static final int KEY_REPLY = 232;
	public static final int KEY_FORWARDMAIL = 233;
	public static final int KEY_SAVE = 234;
	public static final int KEY_DOCUMENTS = 235;

	public static final int KEY_BATTERY = 236;

	public static final int KEY_UNKNOWN = 240;
}
