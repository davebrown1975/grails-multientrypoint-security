package com.tucanoo.mep.tests.pages

import geb.Page

class CapuletLoginPage extends Page {
  static url = 'capulets/auth'
  static at = { title == 'Capulet Login' }
}
