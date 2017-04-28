// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


import java.io.IOException;

import java.util.*;

final class MyJSONParser implements JSONParser {

	public  JSON parse(String in) throws IOException {
		in = in.substring(in.indexOf("{") + 1, in.lastIndexOf('}')).trim();
		MyJSON object = new MyJSON();
		if(in.length() == 0) {
			return object;
		}
		String[] initialSeperate = in.split(":", 2);
		if (initialSeperate[1].contains("{")) {
			parseObject(initialSeperate[1], initialSeperate[0], object);
		} else {
			object = new MyJSON();
			parseString(in, object);
		}
		return object;
	}

	private static void parseObject(String str, String key, MyJSON object) {
		str = str.replace("\"", "");
		key = key.replace("\"", "");
		str = str.replace("{", "");
		str = str.replace("}", "");
		MyJSON tempObject = new MyJSON();
		object.setObject(key, tempObject);
		String [] seperate = str.split(",");
		for (int i = 0; i < seperate.length; i++) {
			parseString(seperate[i], tempObject);
		}
	}

	private static void parseString(String str, MyJSON object) {
		str = str.replace("\"", "").trim();
		String [] seperate = str.split(":");
		object.setString(seperate[0], seperate[1]);
	}
}
